package eu.iums.bootstrap4.frontend.routing

import eu.iums.bootstrap4.frontend.ApplicationContext
import eu.iums.bootstrap4.frontend.views.RootViewFactory
import eu.iums.bootstrap4.frontend.views.chat.ChatViewFactory
import eu.iums.bootstrap4.frontend.views.login.LoginPageViewFactory
import io.udash._

class StatesToViewFactoryDef extends ViewFactoryRegistry[RoutingState] {
  def matchStateToResolver(state: RoutingState): ViewFactory[_ <: RoutingState] =
    state match {
      case RootState => new RootViewFactory(
        ApplicationContext.translationsService
      )
      case LoginPageState => new LoginPageViewFactory(
        ApplicationContext.userService, ApplicationContext.application, ApplicationContext.translationsService
      )
      case ChatState => new ChatViewFactory(
        ApplicationContext.userService, ApplicationContext.translationsService, ApplicationContext.notificationsCenter
      )
    }
}