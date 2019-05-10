package ro.utcn.sd.a3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.utcn.sd.a3.seed.ApplicationSeed;

@Profile("e2e")
@RestController
@RequiredArgsConstructor
public class EndToEndTestsController {
    private final ApplicationSeed seed;

    @RequestMapping("/test/reseed")
    public void reseed() {
        seed.clear();
        seed.run();
    }
}
