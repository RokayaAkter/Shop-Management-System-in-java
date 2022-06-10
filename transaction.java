public class transaction {
	private String Pcode;
	private String Pnum;
	
	transaction() {}
	transaction(String Pcode, String Pnum)
	{
		this.Pcode = Pcode;
		this.Pnum = Pnum;
	}
	
	 public String getPcode() {
	       return Pcode;
	   }
	   public void setPcode(String Pcode) {
	       this.Pcode = Pcode;
	   }
	   public String getPnum() {
	       return Pnum;
	   }
	   public void setPnum(String Pnum) {
	       this.Pnum = Pnum;
	   }
}

