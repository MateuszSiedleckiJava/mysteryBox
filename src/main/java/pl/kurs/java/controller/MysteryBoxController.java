package pl.kurs.java.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.kurs.java.model.Box;
import pl.kurs.java.model.Person;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@RestController
@RequestMapping("/mysteryBox")
@RequiredArgsConstructor
public class MysteryBoxController {


    @GetMapping("/box-for/{pesel}")
    public ResponseEntity<Box> getAllPersons(@PathVariable("pesel") String pesel) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://afternoon-reaches-44220.herokuapp.com/person/Query?pesel=" + pesel;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic YWRtaW46YWRtaW4=");
        HttpEntity<?> request = new HttpEntity<>(headers);
        ResponseEntity<Person[]> response = restTemplate.exchange(url, HttpMethod.GET, request, Person[].class);


        if (response.getStatusCode().equals(HttpStatus.OK)) {
            if (Period.between(Objects.requireNonNull(response.getBody())[0].getBirthDate(), LocalDate.now()).getYears() < 18) {
                return ResponseEntity.ok(new Box("Kurs Java", 30000));
            } else {
                return ResponseEntity.ok(new Box("Wibratorek", 300));
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
