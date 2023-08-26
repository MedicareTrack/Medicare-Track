import React from "react";
import { useState } from "react";
import Product from "../models/product";

const AddProduct = () => {

/* this.name = name;
    this.price = price;
    this.description = description;
    this.stock=stock;
    this.categoryId=categoryId;
    this.expDate=expDate;*/ 
    const [product, setProduct] = useState(new Product('name','price','des', 'stock', 'cate', 'expdate'));
   
    return (
        <>

            <div className="container my-3 py-3">
                <h1 className="text-center">Add Product</h1>
                <hr />
                <div class="row my-4 h-100">
                    <div className="col-md-4 col-lg-4 col-sm-8 mx-auto">
                        <form >
                            <div class="form my-3">
                                <label for="PName">Product Name </label>
                                <input
                                    type="text"
                                    class="form-control"
                                    id="PName"
                                    name="name"
                                    value={product.name}
                                    placeholder="Enter Product Name"
                                    maxLength={20}
                                    required
                                   
                                />
                            </div>


                            <div class="form my-3">
                                <label for="price">Product price</label>
                                <br />
                                <input
                                    type="number"
                                    class="form-control"
                                    name="price"
                                    id="price"
                                    value={product.price}
                                    placeholder="Enter Price Here"
                                    required
                                    maxLength={20}
                                />
                            </div>


                            <div class="form my-3">
                                <label for="description">Product Description </label>
                                <textarea
                                    class="form-control"
                                    name="description"
                                    id="description"
                                    cols="60"
                                    rows="10"
                                    value={product.description}
                                    placeholder="Enter Description Here"
                                    >
                                </textarea>
                            </div>

                            <div class="form my-3">
                                <label for="stock">Product Stock</label>
                                <input
                                    type="number"
                                    class="form-control"
                                    name="stock"
                                    id="stock"
                                    value={product.stock}
                                    placeholder="Enter Stock Here"
                                    required

                                />
                            </div>

                            <div class="form my-3">
                                <label for="categoryId">Category</label>
                                <select
                                    class="form-control"
                                    name="categoryId"
                                    id="categoryId"

                                    placeholder="Enter Stock Here"
                                    required
                                >
                                    <option value="" selected disabled>-- Select The Category --</option>
                                </select>

                            </div>

                            <div class="form my-3">
                                <label for="image">Product Image</label>
                                <input
                                    type="file"
                                    class="form-control"
                                    name="image"
                                    id="image"
                                    placeholder="Enter image Here"
                                    required

                                />
                            </div>


                            <div class="form my-3">
                                <label for="expDate">Product expdate</label>
                                <input
                                    type="date"
                                    class="form-control"
                                    name="expDate"
                                    id="expDate"
                                    placeholder="Enter Stock Here"
                                    required

                                />
                            </div>


                            <div className="text-center">
                                <button class="my-2 mx-auto btn btn-dark" type="submit" >
                                    Add Product
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </>
    );
};

export default AddProduct;