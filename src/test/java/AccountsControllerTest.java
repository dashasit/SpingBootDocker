import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.efi.rogo.application.Application;
import com.efi.rogo.entity.Account;
import com.efi.rogo.entity.Contact;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountsControllerTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void addAccount() {

		Contact contact = new Contact(22222222, 11111111, "EFI", false);
		Account acc = new Account(11111111, "11111", "Rest9", "CustomerStatusNew",
				"cash_check_credit", false, contact, false);

		headers.setContentType(MediaType.APPLICATION_JSON);
		//HttpEntity<Contact> ent = new HttpEntity<Contact>(contact, headers);
		HttpEntity<Account> entity = new HttpEntity<Account>(acc, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/account/add"), HttpMethod.POST, entity,
				String.class);

		//String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
