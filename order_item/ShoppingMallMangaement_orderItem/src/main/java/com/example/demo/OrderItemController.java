package com.example.demo;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderitem")
public class OrderItemController {
	@Autowired
	private OrderItemService service;
	
	@GetMapping()
	public List<OrderItem> list(){
		return service.showAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<OrderItem> get(@PathVariable Integer id){
		try {
			OrderItem order=service.get(id);
			return new ResponseEntity<OrderItem>(order,HttpStatus.OK);
		}
		catch(NoSuchElementException e){
			return new ResponseEntity<OrderItem>(HttpStatus.NOT_FOUND);
			
		}
	}
	
	@PostMapping()
	public void add(@RequestBody OrderItem orderitem) {
		service.save(orderitem);
	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<?> update(@RequestBody OrderItem orderitem,@PathVariable Integer id){
		try {
			OrderItem existorderItem=service.get(id);
			service.save(orderitem);
			return new ResponseEntity<>(HttpStatus.OK);	
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

}
