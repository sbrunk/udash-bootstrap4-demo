package eu.iums.bootstrap4.frontend

import eu.iums.bootstrap4.frontend.routing.{LoginPageState, RoutingRegistryDef, RoutingState, StatesToViewFactoryDef}
import eu.iums.bootstrap4.frontend.services.rpc.{NotificationsCenter, RPCService}
import eu.iums.bootstrap4.frontend.services.{TranslationsService, UserContextService}
import eu.iums.bootstrap4.shared.model.SharedExceptions
import eu.iums.bootstrap4.shared.rpc.client.MainClientRPC
import eu.iums.bootstrap4.shared.rpc.server.MainServerRPC
import io.udash._
import io.udash.rpc._

object ApplicationContext {
  import scala.concurrent.ExecutionContext.Implicits.global

  private val routingRegistry = new RoutingRegistryDef
  private val viewFactoryRegistry = new StatesToViewFactoryDef

  val application = new Application[RoutingState](
    routingRegistry, viewFactoryRegistry, WindowUrlPathChangeProvider
  )

  application.onRoutingFailure {
    case _: SharedExceptions.UnauthorizedException =>
      // automatic redirection to LoginPage
      application.goTo(LoginPageState)
  }

  val notificationsCenter: NotificationsCenter = new NotificationsCenter

  // creates RPC connection to the server
  val serverRpc: MainServerRPC = DefaultServerRPC[MainClientRPC, MainServerRPC](
    new RPCService(notificationsCenter), exceptionsRegistry = new SharedExceptions
  )

  val translationsService: TranslationsService = new TranslationsService(serverRpc.translations())
  val userService: UserContextService = new UserContextService(serverRpc)
}