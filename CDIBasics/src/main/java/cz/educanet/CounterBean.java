package cz.educanet;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.IOException;

@Named
@RequestScoped
public class CounterBean {

    @Inject
    private CounterRepository counterRepository;

    public void increment() throws IOException {
        int count = counterRepository.load();
        counterRepository.save(count + 1);
    }

    public int getCount() {
        return counterRepository.load();
    }

}
