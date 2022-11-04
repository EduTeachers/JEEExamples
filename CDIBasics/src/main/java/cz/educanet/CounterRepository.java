package cz.educanet;

import jakarta.enterprise.context.ApplicationScoped;

import java.io.*;

@ApplicationScoped
public class CounterRepository {

    void save(int count) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("count.txt"));
        bw.write(String.valueOf(count));
        bw.close();
    }

    int load() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("count.txt"));
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            return 0;
        }
    }

}
