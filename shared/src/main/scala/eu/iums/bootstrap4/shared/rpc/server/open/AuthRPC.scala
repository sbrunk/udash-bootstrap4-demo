package eu.iums.bootstrap4.shared.rpc.server.open

import eu.iums.bootstrap4.shared.model.auth.UserContext
import io.udash.rpc._

import scala.concurrent.Future

trait AuthRPC {
  /** Verifies provided username and password.
    * Returns a UserContext if provided data is valid. */
  def login(username: String, password: String): Future[UserContext]
}

object AuthRPC extends DefaultServerUdashRPCFramework.RPCCompanion[AuthRPC]
