package eu.iums.bootstrap4.shared.rpc.client

import eu.iums.bootstrap4.shared.rpc.client.chat.ChatNotificationsRPC
import io.udash.rpc._

trait MainClientRPC {
  def chat(): ChatNotificationsRPC
}

object MainClientRPC extends DefaultClientUdashRPCFramework.RPCCompanion[MainClientRPC]