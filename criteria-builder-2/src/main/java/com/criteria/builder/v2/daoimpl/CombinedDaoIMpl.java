package com.criteria.builder.v2.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.criteria.builder.v2.Entity.Customer;
import com.criteria.builder.v2.Entity.Customer_;
import com.criteria.builder.v2.Entity.Product;
import com.criteria.builder.v2.Entity.Product_;

@Repository
public class CombinedDaoIMpl {
	@Autowired
	EntityManager em;
	
public void  SubqueryMetaModel()
{
	CriteriaBuilder cb=em.getCriteriaBuilder();
	
	CriteriaQuery<Customer> cq= cb.createQuery(Customer.class);
	CriteriaQuery<Product> cq1= cb.createQuery(Product.class);
	
	//Select all customer
	Root<Customer> root1=cq.from(Customer.class);
	TypedQuery<Customer> tq1=em.createQuery(cq);
	List<Customer> list1=tq1.getResultList();
	System.out.println(list1);
	System.out.println("<------------------------------------------------------------------------------------------------------------->\n");
	
	//select all product
	Root<Product> root2=cq1.from(Product.class);
	TypedQuery<Product> tq2=em.createQuery(cq1);
	List<Product> list2=tq2.getResultList();
	System.out.println(list2);
	System.out.println("<------------------------------------------------------------------------------------------------------------->\n");
	
	//Select Customer by name
	Path<String> p1=root1.get("name");
	cq.select(root1).where(cb.equal(p1, "Bharat Rawat"));
	TypedQuery<Customer> tq3=em.createQuery(cq);
	List<Customer> list3=tq3.getResultList();
	System.out.println(list3);
	System.out.println("<---------------------------------------------------------------------------------------------------------------->\n");
	

	//Select Customer by name with MetaModel
	Path<String> p2=root1.get(Customer_.NAME);
	cq.select(root1).where(cb.equal(p1, "Bharat Rawat"));
	TypedQuery<Customer> tq4=em.createQuery(cq);
	List<Customer> list4=tq4.getResultList();
	System.out.println(list4);
	System.out.println("<---------------------------------------------------------------------------------------------------------------->\n");
	
	//Select Customer by name and implementation of MetaModel and Predicate
	Path<String> p3=root1.get(Customer_.NAME);
	Predicate cate1=cb.equal(p3, "Bharat Rawat");
	cq.select(root1).where(cate1);
	TypedQuery<Customer> tq5=em.createQuery(cq);
	List<Customer> list5=tq5.getResultList();
	System.out.println(list5);
	System.out.println("<---------------------------------------------------------------------------------------------------------------->\n");
	
	
}

    // SubQuery 
   // multiSelect-->>need to making constructor, according to selected fields
	public void subquery1(String name)
	{
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaQuery<Product> cq=cb.createQuery(Product.class);
		Root<Product> root=cq.from(Product.class);
		
		//SQL Query-->select p.price,p.qty,p.product_name from product p where p.c_id in(select id from customer where name="Vivek Kumar");
		
		//SubQuery For Internal Query-->.select id from customer where name="Vivek Kumar";
		Subquery<Customer> subquery=cq.subquery(Customer.class);
		
		//Root for subQuery
		Root<Customer> subRoot=subquery.from(Customer.class);
		
		//SubQuery For Internal Query-->.select id from customer where name="Vivek Kumar";
		//Getting Customer ID from this query
		subquery.select(subRoot.get(Customer_.ID)).where(cb.equal(subRoot.get(Customer_.NAME),name));
		
		//Final Query-->// SQL Query-->select p.price,p.qty,p.product_name from product p where p.c_id in(select id from customer where name="Vivek Kumar");
		cq.multiselect(root.get(Product_.PRICE),
				       root.get(Product_.QTY),
				       root.get(Product_.PRODUCT_NAME))
		               .where(root.get(Product_.C_ID).in(subquery));
		
		TypedQuery<Product> query=em.createQuery(cq);
		List<Product> list=query.getResultList();
		System.out.println(list);
		System.out.println("<---------------------------------------------------------------------------------------------------------------->\n");
		
	}
	
	// Using Tuple in above Query
	//No need to making constructor , according to selected fields
	public void subquery2(String name)
	{
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaQuery<Tuple> cq=cb.createTupleQuery();
		Root<Product> root=cq.from(Product.class);
		
		//SQL Query-->select p.price,p.qty,p.product_name from product p where p.c_id in(select id from customer where name="Vivek Kumar");
		
		//SubQuery For Internal Query-->.select id from customer where name="Vivek Kumar";
		Subquery<Customer> subquery=cq.subquery(Customer.class);
		
		//Root for subQuery
		Root<Customer> subRoot=subquery.from(Customer.class);
		
		//SubQuery For Internal Query-->.select id from customer where name="Vivek Kumar";
		//Getting Customer ID from this query
		subquery.select(subRoot.get(Customer_.ID)).where(cb.equal(subRoot.get(Customer_.NAME),name));
		
		//Final Query-->// SQL Query-->select p.price,p.qty,p.product_name from product p where p.c_id in(select id from customer where name="Vivek Kumar");
		cq.select(cb.tuple(root.get(Product_.PRICE),
				           root.get(Product_.QTY),
				           root.get(Product_.PRODUCT_NAME))
				         )
		                       .where(root.get(Product_.C_ID).in(subquery));
		
	
	
	TypedQuery<Tuple> typedQuery= em.createQuery(cq);
	
	List<Tuple> list= typedQuery.getResultList();
	list.forEach(e->{
		System.out.println("prince : " +e.get(0) +"\n"+"qty : " + e.get(1) +"\n" +"product name :" + e.get(2));
	});
		System.out.println("<---------------------------------------------------------------------------------------------------------------->\n");
		
	}
	
	//Case Expressions with CriteriaBuilder.selectCase()
	public void selectCase()
	{
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaQuery<Customer> cq=cb.createQuery(Customer.class);
		Root<Customer> root=cq.from(Customer.class);
		
		/*
		 * SQL Query-->>select 
		 * case 
		 * c.name 
		 * when "Bharat Rawat" then "Mr.Bharat Rawat"
		 * when "Vivek Kumar" then "Mr. Vivek Kumar" 
		 * else 
		 * c.name 
		 * end as result 
		 * from customer c;
		 */
		//Method Chaining
		cq.multiselect(root.get(Customer_.NAME),   
				   cb.selectCase()
				   .when(cb.equal(root.get(Customer_.NAME), "Vivek Kumar"), "Mr. Vivek Kumar")
				   .when(cb.equal(root.get(Customer_.NAME), "Bharat Rawat"),"Mr. Bharat Rawat")
				   .otherwise(root.get(Customer_.NAME))
				    );
		
					TypedQuery<Customer> typedQuery = em.createQuery(cq);

					List<Customer> list = typedQuery.getResultList();
					System.out.println(list);
					System.out.println("<---------------------------------------------------------------------------------------------------------------->\n");
	}
	
	// Applying Join in one-to many
	public void joinsImplementation()
	{
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaQuery<Customer> cq=cb.createQuery(Customer.class);
		Root<Customer> root=cq.from(Customer.class);
		
		/*SQL Query-->> select * from customer c 
		 *              inner join product p 
		 *              where c.id=p.cp_fk; 
		 */
		
		Join<Customer, Product> prodcut=root.join(Customer_.PRODUCTS);
		
		Predicate cate1=cb.equal(prodcut.get(Product_.C_ID),root.get(Customer_.ID));
		cq.select(root).where(cate1);
	
		TypedQuery<Customer> typedQuery = em.createQuery(cq);
		List<Customer> list = typedQuery.getResultList();
		System.out.println(list);
		System.out.println("<---------------------------------------------------------------------------------------------------------------->\n");
		
	
	}
	

}

