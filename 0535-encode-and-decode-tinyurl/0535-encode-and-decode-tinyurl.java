public class Codec {
    private Map<Integer, String> map;
    private int counter;
    private String BASE_URL = "https://shorturl/";

    public Codec () {
        map = new HashMap<>();
        counter = 0;
    } 

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        counter++;
        map.put(counter, longUrl); 
        return BASE_URL + counter;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int extractedId = Integer.parseInt(shortUrl.replace(BASE_URL,  "")); 
        return map.get(extractedId);   
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));