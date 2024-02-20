package person;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Person {

    PERSON("demo", "demo");

    String login;
    String password;
}
