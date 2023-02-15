package com.assignment.phonebook;

import com.assignment.phonebook.controller.PhonebookController;
import com.assignment.phonebook.entity.Phonebook;
import com.assignment.phonebook.repository.PhonebookRepository;
import com.assignment.phonebook.service.ValidationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PhonebookApplicationTests {

	@Autowired
	PhonebookRepository repository;

	@Test
	public void testCreate() {
		Phonebook pbook = new Phonebook();
		pbook.setId("22");
		pbook.setName("Srikar");
		pbook.setPhoneNumber("1234567890");
		repository.save(pbook);
		Assertions.assertNotNull(repository.findMaxId());
	}

	@Test
	public void testReadAll() {
		Phonebook pbook = new Phonebook();
		pbook.setId("25");
		pbook.setName("Mani");
		pbook.setPhoneNumber("1234565690");
		repository.save(pbook);
		List<Phonebook> list = repository.findAll();
		Assertions.assertTrue(list.size()>0);
	}

	@Test
	public void testDelete() {
		Phonebook pbook = new Phonebook();
		pbook.setId("61");
		pbook.setName("Manasa");
		pbook.setPhoneNumber("+1 682 330-1172");
		repository.save(pbook);
		List<Phonebook> contacts = repository.findByPhoneNumber(pbook.getPhoneNumber());
		contacts.forEach(p -> repository.delete(p));
		List<Phonebook> list = repository.findAll();
		Assertions.assertNotEquals(pbook, list.get(0));
	}

	@Test
	public void testPhoneNumberValidations() {
		Phonebook pbook = new Phonebook();
		pbook.setId("12");
		pbook.setPhoneNumber("12345");
		pbook.setName("srikar");
		ValidationService vd = new ValidationService();
		boolean b = vd.validatePhone(pbook);
		Assertions.assertTrue(b);
	}

	@Test
	public void testPhoneNumberValidations2() {
		Phonebook pbook = new Phonebook();
		pbook.setId("12");
		pbook.setPhoneNumber("1234567");
		pbook.setName("srikar");
		ValidationService vd = new ValidationService();
		boolean b = vd.validatePhone(pbook);
		Assertions.assertFalse(b);
	}

	@Test
	public void testPhoneNumberValidations3() {
		Phonebook pbook = new Phonebook();
		pbook.setId("12");
		pbook.setPhoneNumber("7031111234");
		pbook.setName("srikar");
		ValidationService vd = new ValidationService();
		boolean b = vd.validatePhone(pbook);
		Assertions.assertFalse(b);
	}

	@Test
	public void testPhoneNumberValidations4() {
		Phonebook pbook = new Phonebook();
		pbook.setId("12");
		pbook.setPhoneNumber("+1234 (201) 123-1234");
		pbook.setName("srikar");
		ValidationService vd = new ValidationService();
		boolean b = vd.validatePhone(pbook);
		Assertions.assertFalse(b);
	}

	@Test
	public void testPhoneNumberValidations5() {
		Phonebook pbook = new Phonebook();
		pbook.setId("12");
		pbook.setPhoneNumber("(001) 123-1234");
		pbook.setName("srikar");
		ValidationService vd = new ValidationService();
		boolean b = vd.validatePhone(pbook);
		Assertions.assertFalse(b);
	}

	@Test
	public void testPhoneNumberValidations6() {
		Phonebook pbook = new Phonebook();
		pbook.setId("12");
		pbook.setPhoneNumber("(703) 123-1234 ext 204");
		pbook.setName("srikar");
		ValidationService vd = new ValidationService();
		boolean b = vd.validatePhone(pbook);
		Assertions.assertFalse(b);
	}

	@Test
	public void testPhoneNumberValidations7() {
		Phonebook pbook = new Phonebook();
		pbook.setId("12");
		pbook.setPhoneNumber("+32 (21) 212-2324");
		pbook.setName("srikar");
		ValidationService vd = new ValidationService();
		boolean b = vd.validatePhone(pbook);
		Assertions.assertTrue(b);
	}

	@Test
	public void testPhoneNumberValidations8() {
		Phonebook pbook = new Phonebook();
		pbook.setId("12");
		pbook.setPhoneNumber("123-1234");
		pbook.setName("srikar");
		ValidationService vd = new ValidationService();
		boolean b = vd.validatePhone(pbook);
		Assertions.assertTrue(b);
	}

	@Test
	public void testPhoneNumberValidations9() {
		Phonebook pbook = new Phonebook();
		pbook.setId("12");
		pbook.setPhoneNumber("(703)111-2121");
		pbook.setName("srikar");
		ValidationService vd = new ValidationService();
		boolean b = vd.validatePhone(pbook);
		Assertions.assertTrue(b);
	}

	@Test
	public void testPhoneNumberValidations10() {
		Phonebook pbook = new Phonebook();
		pbook.setId("12");
		pbook.setPhoneNumber("+1(703)111-2121");
		pbook.setName("srikar");
		ValidationService vd = new ValidationService();
		boolean b = vd.validatePhone(pbook);
		Assertions.assertTrue(b);
	}

	@Test
	public void testPhoneNumberValidations11() {
		Phonebook pbook = new Phonebook();
		pbook.setId("12");
		pbook.setPhoneNumber("12345.12345");
		pbook.setName("srikar");
		ValidationService vd = new ValidationService();
		boolean b = vd.validatePhone(pbook);
		Assertions.assertTrue(b);
	}

	@Test
	public void testPhoneNumberValidations12() {
		Phonebook pbook = new Phonebook();
		pbook.setId("12");
		pbook.setPhoneNumber("011 1 703 111 1234");
		pbook.setName("srikar");
		ValidationService vd = new ValidationService();
		boolean b = vd.validatePhone(pbook);
		Assertions.assertTrue(b);
	}

	@Test
	public void testNameValidations() {
		Phonebook pbook = new Phonebook();
		pbook.setId("12");
		pbook.setPhoneNumber("011 1 703 111 1234");
		pbook.setName("srikar");
		ValidationService vd = new ValidationService();
		boolean b = vd.validateName(pbook);
		Assertions.assertFalse(b);
	}

	@Test
	public void testNameValidations1() {
		Phonebook pbook = new Phonebook();
		pbook.setId("12");
		pbook.setPhoneNumber("011 1 703 111 1234");
		pbook.setName("Srikar");
		ValidationService vd = new ValidationService();
		boolean b = vd.validateName(pbook);
		Assertions.assertTrue(b);
	}

	@Test
	public void testNameValidations2() {
		Phonebook pbook = new Phonebook();
		pbook.setId("12");
		pbook.setPhoneNumber("011 1 703 111 1234");
		pbook.setName("Bruce Schneier");
		ValidationService vd = new ValidationService();
		boolean b = vd.validateName(pbook);
		Assertions.assertTrue(b);
	}

	@Test
	public void testNameValidations3() {
		Phonebook pbook = new Phonebook();
		pbook.setId("12");
		pbook.setPhoneNumber("011 1 703 111 1234");
		pbook.setName("Ron O’’Henry");
		ValidationService vd = new ValidationService();
		boolean b = vd.validateName(pbook);
		Assertions.assertFalse(b);
	}

	@Test
	public void testNameValidations4() {
		Phonebook pbook = new Phonebook();
		pbook.setId("12");
		pbook.setPhoneNumber("011 1 703 111 1234");
		pbook.setName("Brad Everett Samuel Smith");
		ValidationService vd = new ValidationService();
		boolean b = vd.validateName(pbook);
		Assertions.assertFalse(b);
	}

	@Test
	public void testNameValidations5() {
		Phonebook pbook = new Phonebook();
		pbook.setId("12");
		pbook.setPhoneNumber("011 1 703 111 1234");
		pbook.setName("O’Malley, John F.");
		ValidationService vd = new ValidationService();
		boolean b = vd.validateName(pbook);
		Assertions.assertTrue(b);
	}

	@Test
	public void testNameValidations6() {
		Phonebook pbook = new Phonebook();
		pbook.setId("12");
		pbook.setPhoneNumber("011 1 703 111 1234");
		pbook.setName("Schneier, Bruce");
		ValidationService vd = new ValidationService();
		boolean b = vd.validateName(pbook);
		Assertions.assertTrue(b);
	}

	@Test
	public void testNameValidations7() {
		Phonebook pbook = new Phonebook();
		pbook.setId("12");
		pbook.setPhoneNumber("011 1 703 111 1234");
		pbook.setName("L33t Hacker");
		ValidationService vd = new ValidationService();
		boolean b = vd.validateName(pbook);
		Assertions.assertFalse(b);
	}

	@Test
	public void testNameValidations8() {
		Phonebook pbook = new Phonebook();
		pbook.setId("12");
		pbook.setPhoneNumber("011 1 703 111 1234");
		pbook.setName("John O’Malley-Smith");
		ValidationService vd = new ValidationService();
		boolean b = vd.validateName(pbook);
		Assertions.assertTrue(b);
	}

	@Test
	public void testNameValidations9() {
		Phonebook pbook = new Phonebook();
		pbook.setId("12");
		pbook.setPhoneNumber("011 1 703 111 1234");
		pbook.setName("Ron O’Henry-Smith-Barnes");
		ValidationService vd = new ValidationService();
		boolean b = vd.validateName(pbook);
		Assertions.assertFalse(b);
	}

	@Test
	public void testNameValidations10() {
		Phonebook pbook = new Phonebook();
		pbook.setId("12");
		pbook.setPhoneNumber("011 1 703 111 1234");
		pbook.setName("Srikar uddadi");
		ValidationService vd = new ValidationService();
		boolean b = vd.validateName(pbook);
		Assertions.assertFalse(b);
	}

	@Test
	public void testProjectIsRunning() {
		PhonebookController pc = new PhonebookController();
		String str = pc.Info();
		Assertions.assertEquals("The application is up...",str);
	}
}
