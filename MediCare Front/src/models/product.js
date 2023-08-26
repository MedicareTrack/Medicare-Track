export default class Product {
  constructor(name,price, description,stock ,categoryId,expDate) {
    this.name = name;
    this.price = price;
    this.description = description;
    this.stock=stock;
    this.categoryId=categoryId;
    this.expDate=expDate;
  }
}
