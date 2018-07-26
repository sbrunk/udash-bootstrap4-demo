package eu.iums.bootstrap4.shared.rpc.server.secure

import eu.iums.bootstrap4.shared.rpc.server.secure.chat.ChatRPC
import io.udash.rpc._

trait SecureRPC {
  def chat(): ChatRPC
}

object SecureRPC extends DefaultServerUdashRPCFramework.RPCCompanion[SecureRPC]
