package nl.nn.adapterframework.xslt;

import nl.nn.adapterframework.pipes.GenericMessageSendingPipe;
import nl.nn.adapterframework.senders.XsltSender;

public class XsltSenderTest extends XsltErrorTestBase<GenericMessageSendingPipe> {

	protected XsltSender sender;
	
	@Override
	public GenericMessageSendingPipe createPipe() {
		GenericMessageSendingPipe pipe=new GenericMessageSendingPipe();
		sender = new XsltSender();
		pipe.setSender(sender);
		return pipe;
	}


	@Override
	protected void setStyleSheetName(String styleSheetName) {
		sender.setStyleSheetName(styleSheetName);		
	}

	@Override
	protected void setXslt2(boolean xslt2) {
		sender.setXslt2(xslt2);
	}

}