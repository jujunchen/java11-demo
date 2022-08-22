package other;

import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Other {

    @Test
    public void ListOfTest() {
        List<String> stringList = List.of("a", "b", "c", "d");
        List<String> stringList2 = List.of("a", "b", "c", "d");
        System.out.println(stringList.hashCode());
        System.out.println(stringList2.hashCode());
    }

    @Test
    public void ofNullable() {
        Stream<Integer> stream = Stream.of(1, 2, null);
        stream.forEach(System.out::print);
        System.out.println();

        // 空指针异常
        // stream = Stream.of(null);
        stream = Stream.ofNullable(null);
        stream.forEach(System.out::print);
    }

    @Test
    public void repeatTest() {
        String repeat = "CSDN/WX-阿提说说";
        String repeat3 = repeat.repeat(3);
        System.out.println(repeat3);
    }

    @Test
    public void fileApiTest() throws IOException {
        // 创建临时文件
        Path path = Files.writeString(Files.createTempFile("test", ".txt"),  "https://www.baidu.com");
        System.out.println(path);
        // 读取文件
        String s = Files.readString(path);
        System.out.println(s);
    }

    @Test
    public void httpClientTest() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.hao123.com"))
                .build();
        // 异步
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();

        // 同步
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

    }


    @Test
    public void lambdaVarTest() {
        var hashMap = new HashMap<String, Object>();
        hashMap.put("wechat", "wlw");
        hashMap.put("website", "https://www.baidu.com");
        hashMap.forEach((var k, var v) -> {
            System.out.println(k + ": " + v);
        });
    }

    @Test
    public void java14NullPointerExceptions() {
        String content1 = "www.baidu.com";
        String content2 = null;
        int length = content1.length() + content2.length();
        System.out.println(length);
    }

    @Test
    public void SPITest() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("www.csdn.net");
        System.out.println(inetAddress.getHostAddress());
    }

    public static void main(String[] args) {
        testStrictfp();
    }

    public strictfp static void testStrictfp() {
        float aFloat = 0.6666666666666666666f;
        double aDouble = 0.88888888888888888d;
        double sum = aFloat + aDouble;
        System.out.println("sum: " + sum);
    }
}
