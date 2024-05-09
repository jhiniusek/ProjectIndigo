package org.inchcape.projectindigo.dealer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Dealer not found")
public class DealerNotFoundException extends RuntimeException {
}
