package idv.caemasar.entity;

public class ExtensionContent {
	private String extensionName;
	private String contentType;

	public ExtensionContent() {

	}

	public ExtensionContent(String extensionName, String contentType) {
		this.extensionName = extensionName;
		this.contentType = contentType;
	}

	public String getExtensionName() {
		return extensionName;
	}

	public void setExtensionName(String extensionName) {
		this.extensionName = extensionName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Override
	public String toString() {
		return "ExtensionContent [extensionName=" + extensionName + ", contentType=" + contentType + "]";
	}

}
