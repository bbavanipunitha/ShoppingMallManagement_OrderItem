package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class OrderItemService {


		@Autowired
		private OrderItemRepository repository;
		
		public List<OrderItem> showAll(){
			return repository.findAll();
		}
		
		public void save(OrderItem order) {
			repository.save(order);
		}

		public OrderItem get(Integer id) {
			// TODO Auto-generated method stub
			return repository.findById(id).get();
		}
		
		public void delete(Integer id) {
			repository.deleteById(id);
		}
	}
