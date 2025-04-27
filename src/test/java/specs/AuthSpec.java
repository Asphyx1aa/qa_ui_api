package specs;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.with;
import static specs.BaseSpec.baseSpec;

public class AuthSpec {
    public static final RequestSpecification auth = with()
            .spec(baseSpec);
}
