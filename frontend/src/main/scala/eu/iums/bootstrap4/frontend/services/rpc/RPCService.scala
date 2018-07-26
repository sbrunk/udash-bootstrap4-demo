package eu.iums.bootstrap4.frontend.services.rpc

import eu.iums.bootstrap4.shared.rpc.client.MainClientRPC
import eu.iums.bootstrap4.shared.rpc.client.chat.ChatNotificationsRPC

class RPCService(notificationsCenter: NotificationsCenter) extends MainClientRPC {
  override val chat: ChatNotificationsRPC =
    new ChatService(notificationsCenter.msgListeners, notificationsCenter.connectionsListeners)
}