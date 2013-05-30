
package eu.justas.jweather.domain.gen;


public class Response{
   	private Features features;
   	private String termsofService;
   	private String version;

 	public Features getFeatures(){
		return this.features;
	}
	public void setFeatures(Features features){
		this.features = features;
	}
 	public String getTermsofService(){
		return this.termsofService;
	}
	public void setTermsofService(String termsofService){
		this.termsofService = termsofService;
	}
 	public String getVersion(){
		return this.version;
	}
	public void setVersion(String version){
		this.version = version;
	}
}
