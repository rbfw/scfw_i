package scfw.model.comm;

import org.springframework.web.servlet.ModelAndView;

public class JsonBean extends ModelAndView{
	private int isSuccess = CT.SUCCESS;
	private String msgInfo = CT.SUCCESS_INFO;

	public int getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(int isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getMsgInfo() {
		return msgInfo;
	}

	public void setMsgInfo(String msgInfo) {
		this.msgInfo = msgInfo;
	}
	
}
