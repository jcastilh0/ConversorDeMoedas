import java.util.Map;

public record MoedaResponse(String result, String base_code, Map<String, Double> conversion_rates) {
}
