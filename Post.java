package jdbc_Krushimart_sevlets;

public class Post {
  private int id;
  private String product;
  private double price;
  private int quatity;
  private String email_id;
  
  public void setEmail_Id(String id) {
	  this.email_id=id;
  }
  public String getEmail_Id()
  {
	  return email_id;
  }
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getProduct() {
	return product;
}
public void setProduct(String product) {
	this.product = product;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getQuatity() {
	return quatity;
}
public void setQuatity(int quatity) {
	this.quatity = quatity;
}
  
  
}
