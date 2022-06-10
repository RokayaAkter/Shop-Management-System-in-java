public class Stock {
	   private String Id;
	   private String name;
	   private String stocknum;
	   private String price;
	   
	   Stock() {}
	   
	   public Stock(String Id, String name, String stocknum, String price) {
		   this.Id = Id;
	       this.name = name;
	       this.stocknum = stocknum;
	       this.price = price;
	   }
	   public String getName() {
	       return name;
	   }
	   public void setName(String name) {
	       this.name = name;
	   }
	   public String getId() {
	       return Id;
	   }

	   public void setId(String Id) {
	       this.Id = Id;
	   }

	   public String getstocknum() {
	       return stocknum;
	   }

	   public void setstocknum(String stocknum) {
	       this.stocknum = stocknum;
	   }

	   public String getprice() {
	       return price;
	   }

	   public void setprice(String price) {
	       this.price = price;
	   }
	   
	   public String toString()
	   {
		   return Id + " " + name + " " + stocknum + " " + price ;
	   }

}

