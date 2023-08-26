import React, { useState, useEffect } from "react";


import ProductService from '../services/product.service';
import CategoryService from '../services/category.service';
import "react-loading-skeleton/dist/skeleton.css";


const   Products = () => {


  const [data, setData] = useState([]);
  const [filter, setFilter] = useState(data);
  const [categorie, setCategorie] = useState([]);
  const BASE_URL="http://localhost:8080/products/";

 


  //Fetched Data From Backend
  useEffect(() => {
    
    ProductService.getAllProducts().then((response) => {
      setData(response.data);
      setFilter(response.data);
    });

    CategoryService.getAllCategories().then((response) => {
      setCategorie(response.data);
    });

  }, []);


  const filterProduct = (id) => {

    
    ProductService.getProductsByCategory(id).then((response)=>{
      setFilter(response.data)
    });
    
  }


  const  ShowProducts = () => {
    return (
      <>
        <div className="buttons text-center py-5">
          <button className="btn btn-outline-dark btn-sm m-2" onClick={() => setFilter(data)}>All</button>
          {categorie.map((cat)=>{
            console.log(BASE_URL + cat.id );
            return <button className="btn btn-outline-dark btn-sm m-2" onClick={() => filterProduct(cat.id)}>{cat.categoryName}</button>
          })}

        </div>
        
        {filter.map((product) => {
          return (
            <div className="col-md-4 col-sm-6 col-xs-8 col-12 mb-4">
              <div className="card text-center h-100" >
                <img
                  className="card-img-top p-3"
                  src="*"
                  alt="Card"
                  height={300}
                />
                <div className="card-body">
                  <h5 className="card-title">
                    {product.name.substring(0, 12)}...
                  </h5>
                  <p className="card-text">
                    {product.description.substring(0, 90)}...
                  </p>
                </div>
                <ul className="list-group list-group-flush">
                  <li className="list-group-item lead">Rs. {product.price}</li>
                </ul>
                <div className="card-body">
                  <button className="btn btn-dark m-1" >
                    Add to Cart
                  </button>
                </div>
              </div>
            </div>

          );
        })}
      </>
    );
  };
  return (
    <>
      <div className="container my-3 py-3">
        <div className="row">
          <div className="col-12">
            <h2 className="display-5 text-center">Latest Products</h2>
            <hr />
          </div>
        </div>
        <div className="row justify-content-center">
          <ShowProducts />
        
        </div>
      </div>
    </>
  );
};

export default Products;
