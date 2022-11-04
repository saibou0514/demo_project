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
	public List<Person> getPersonInfo() {//���o�Ҧ��ӤH��T
//		Person person1 = new Person("A12", "���p��", 23);
//		Person person2 = new Person("D45", "���p��", 31);
//		Person person3 = new Person("N67", "���p��", 28);

		List<Person> list =personDao.findAll();
		return list;
	}

	@Override
	public Person getPersonId(String id) {//�z�Lid���������ӤH��T
		
		Optional<Person> personOp =personDao.findById(id);
//		Optional �O�Ȫ��e���A�u����ت��A�A���O���ȴN�O�S�ȡC�ت��O���� null �����N��סC
		
//		if(personOp.isPresent()) { //�̭��O�_���ȡA�p�G���Nget
//			�T�{�O�_���� �@�w�n�f�t.isPresent��k
//			Person per = personOp.get();
//			System.out.println(per.getId());
//			System.out.println(per.getAge());
//			return personOp.get();
//		}else {
//			return new Person();
//		}
		
//		�W�z��k�i�H�H�U�@��{���X�N��
		return personOp.orElse(new Person());
//		orElse:�P�_�O�_����
		
//		��²�u�g�k:
//		return personDao.findById(id).orElse(new Person());
		
//		�ĤG�ؼg�k: =================================
//		List<Person> list = personDao.findAll();
//		
		
	}

	@Override
	public List<Person> getPersonInfoByAgeLargerThan(int age) {//��X�~���j���J���󪺩Ҧ��ӤH��T

		List<Person> list = personDao.findByAgeGreaterThan(age);
		return list;
		
		
	}
		
	@Override
	public List<Person> getPersonByNameAndAgeGreaterThan(String name, int age){
//		��W�r�@�˦��~�֤��@�˪���H
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
