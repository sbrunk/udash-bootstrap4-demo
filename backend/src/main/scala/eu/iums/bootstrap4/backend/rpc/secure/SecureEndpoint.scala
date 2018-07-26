package eu.iums.bootstrap4.backend.rpc.secure

import eu.iums.bootstrap4.backend.rpc.secure.chat.ChatEndpoint
import eu.iums.bootstrap4.backend.services.DomainServices
import eu.iums.bootstrap4.shared.model.auth.UserContext
import eu.iums.bootstrap4.shared.rpc.server.secure.SecureRPC
import eu.iums.bootstrap4.shared.rpc.server.secure.chat.ChatRPC

class SecureEndpoint(implicit domainServices: DomainServices, ctx: UserContext) extends SecureRPC {
  import domainServices._

  lazy val chatEndpoint = new ChatEndpoint

  override def chat(): ChatRPC = chatEndpoint
}
