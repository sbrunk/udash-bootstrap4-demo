package eu.iums.bootstrap4.frontend.views.chat

import eu.iums.bootstrap4.shared.model.chat.ChatMessage
import io.udash._

case class ChatModel(msgs: Seq[ChatMessage], msgInput: String, connectionsCount: Int)
object ChatModel extends HasModelPropertyCreator[ChatModel]
