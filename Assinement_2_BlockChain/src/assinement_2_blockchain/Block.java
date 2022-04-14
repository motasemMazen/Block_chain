
package assinement_2_blockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;



public class Block {

	private String version,hashCode,previousHashCode,data;
	private Date Times;

	
	public Block(String version, Date timestamp, String data) {
		this.version = version;
		this.Times = timestamp;
		this.data = data;
		this.hashCode = calculateHash();
	}
	
	public String calculateHash() {
		
		String dataToHash = "" + this.version + this.Times + this.previousHashCode + this.data;
		
		MessageDigest digest;
		String encoded = null;
		
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(dataToHash.getBytes(StandardCharsets.UTF_8));
			encoded = Base64.getEncoder().encodeToString(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		this.hashCode = encoded;
		return encoded;
		
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getTimestamp() {
		return Times;
	}

	public void setTimestamp(Date timestamp) {
		Times = timestamp;
	}

	public String getHash() {
		return hashCode;
	}

	public void setHash(String hash) {
		this.hashCode = hash;
	}

	public String getPreviousHash() {
		return hashCode;
	}

	public void setPreviousHash(String previousHash) {
		this.hashCode = previousHash;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
	
}
    
