package com.example.demo1006.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1006.entity.Person;
import com.example.demo1006.repository.PersonDao;
import com.example.demo1006.service.ifs.PersonService;
@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	public PersonDao personDao;

	@Override
	public List<Person> getPersonInfo() {//取得所有個人資訊
//		Person person1 = new Person("A12", "王小美", 23);
//		Person person2 = new Person("D45", "陳小菊", 31);
//		Person person3 = new Person("N67", "黃小明", 28);

		List<Person> list =personDao.findAll();
		return list;
	}

	@Override
	public Person getPersonId(String id) {//透過id找到對應的個人資訊
		
		Optional<Person> personOp =personDao.findById(id);
//		Optional 是值的容器，只有兩種狀態，不是有值就是沒值。目的是做為 null 的替代方案。
		
//		if(personOp.isPresent()) { //裡面是否有值，如果有就get
//			確認是否有值 一定要搭配.isPresent方法
//			Person per = personOp.get();
//			System.out.println(per.getId());
//			System.out.println(per.getAge());
//			return personOp.get();
//		}else {
//			return new Person();
//		}
		
//		上述方法可以以下一行程式碼代替
		return personOp.orElse(new Person());
//		orElse:判斷是否有值
		
//		更簡短寫法:
//		return personDao.findById(id).orElse(new Person());
		
//		第二種寫法: =================================
//		List<Person> list = personDao.findAll();
//		
		
	}

	@Override
	public List<Person> getPersonInfoByAgeLargerThan(int age) {//找出年紀大於輸入條件的所有個人資訊

		List<Person> list = personDao.findByAgeGreaterThan(age);
		return list;
		
		
	}
		
	@Override
	public List<Person> getPersonByNameAndAgeGreaterThan(String name, int age){
//		找名字一樣但年齡不一樣的兩人
		List<Person> personPP =personDao.findByNameAndAgeGreaterThan(name, age);
		return personPP;
		
	}


		
//		List<Person> list = new ArrayList<>();
//		List<Person> list2 =new ArrayList<>();
//		for(Person pp : list) {
//			if(pp.getAge() > age) {
//				list2.add(pp);
//			}
//		}
//		return list2;
//		==================================
//		if(age > person1.getAge()) {
//			List<Person> list2= new ArrayList<>();
//			list2.add(person3);
//			return list2;
//		}else if(age > person2.getAge()) {
//			return null;
//		}else if(age > person3.getAge()) {
//			List<Person> list3= new ArrayList<>();
//			list3.add(person2);
//			return list3;
//		}else return null;
		
	

}
