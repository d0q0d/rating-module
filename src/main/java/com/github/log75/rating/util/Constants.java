package com.github.log75.rating.util;

/**
 * The Constants Class.
 *
 */
public class Constants {
    private Constants() {}
    public static final String RELATED_ID_ERROR = "Related Id most not be null";
    public static final String RATE_VALUE_ERROR = "Value most not be null";
    public static final String RATE_VALUE_ENUM_ERROR = "Rate Enum most not be null";
    public static final String VALUE_MODEL_PROPERTY = "the rate value";
    public static final String VALUE_MODEL_PROPERTY_EXAMPLE = "4";
    public static final String COMMENT_MODEL_PROPERTY = "user comment";
    public static final String COMMENT_MODEL_PROPERTY_EXAMPLE = "I hate actors. They never act like people. They just think they do.";
    public static final String RELATED_MODEL_PROPERTY = "orderId, productId,...";
    public static final String RELATED_MODEL_PROPERTY_EXAMPLE = "5fabdac931bered0ab7b67ead";
    public static final String POSITIVE_OPINION_MODEL_PROPERTY = "positive opinions";
    public static final String POSITIVE_OPINION_MODEL_PROPERTY_EXAMPLE = "[\"very good\", \"masterpiece\"]";
    public static final String NEGATIVE_OPINION_MODEL_PROPERTY = "negative opinions";
    public static final String NEGATIVE_OPINION_MODEL_PROPERTY_EXAMPLE = "[\"very bad\", \"bullshit\"]";
    public static final String META_DATA_MODEL_PROPERTY = "meta data";
    public static final String META_DATA_MODEL_PROPERTY_EXAMPLE =  "{\"orderName\": \"phone\", \"orderPrice\" : 1000}";
    public static final String META_DATA_MODEL_PROPERTY_DATA_TYPE =  "Map[String,Object]";
    public static final String META_DATA_MODEL_PROPERTY_REFERENCE = "Map";
    public static final String TITLE_MODEL_PROPERTY = "title";
    public static final String TITLE_MODEL_PROPERTY_EXAMPLE = "People always clap for the wrong reasons.";
    public static final String DESCRIPTION_MODEL_PROPERTY = "description";
    public static final String DESCRIPTION_MODEL_PROPERTY_EXAMPLE = "The best thing, though, in that museum was that everything always stayed right where it was. Nobody’d move. . . . Nobody’d be different. The only thing that would be different would be you.";
    public static final String RATE_ENDPOINT = "/api/v1/rates";
    public static final String RATE_OPINION_ENDPOINT = "/api/v1/rates/opinions";
}
