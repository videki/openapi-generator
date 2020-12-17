/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.0.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import java.math.BigDecimal;
import org.openapitools.model.Client;
import org.openapitools.model.FileSchemaTestClass;
import org.openapitools.model.HealthCheckResult;
import java.time.LocalDate;
import java.util.Map;
import org.openapitools.model.ModelApiResponse;
import java.time.OffsetDateTime;
import org.openapitools.model.OuterComposite;
import org.openapitools.model.Pet;
import org.openapitools.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.Explode;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.enums.ParameterStyle;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "fake", description = "the fake API")
public interface FakeApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /fake/health : Health check endpoint
     *
     * @return The instance started successfully (status code 200)
     */
    @Operation(summary = "Health check endpoint", operationId = "fakeHealthGet", tags={ "fake", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "200", description = "The instance started successfully" , content = { @Content( schema = @Schema(implementation = HealthCheckResult.class)) }) })

    @GetMapping(
        value = "/fake/health",
        produces = { "application/json" }
    )
    default ResponseEntity<HealthCheckResult> fakeHealthGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"NullableMessage\" : \"NullableMessage\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /fake/http-signature-test : test http signature authentication
     *
     * @param pet Pet object that needs to be added to the store (required)
     * @param query1 query parameter (optional)
     * @param header1 header parameter (optional)
     * @return The instance started successfully (status code 200)
     */
    @Operation(summary = "test http signature authentication", operationId = "fakeHttpSignatureTest", security = {
        @SecurityRequirement(name = "http_signature_test"
        /*(TODO non OAuth auth), @Authorization(value = "http_signature_test") */
        ) }, tags={ "fake", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "200", description = "The instance started successfully" ) })

    @GetMapping(
        value = "/fake/http-signature-test",
        consumes = { "application/json", "application/xml" }
    )
    default ResponseEntity<Void> fakeHttpSignatureTest(@Parameter(description = "Pet object that needs to be added to the store" ,required=true )  @Valid @RequestBody Pet pet,@Parameter(description = "query parameter") @Valid @RequestParam(value = "query_1", required = false) Optional<String> query1,@Parameter(description = "header parameter" ) @RequestHeader(value="header_1" , required=false) Optional<String> header1) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /fake/outer/boolean
     * Test serialization of outer boolean types
     *
     * @param body Input boolean as post body (optional)
     * @return Output boolean (status code 200)
     */
    @Operation(summary = "", operationId = "fakeOuterBooleanSerialize", tags={ "fake", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "200", description = "Output boolean" , content = { @Content( schema = @Schema(implementation = Boolean.class)) }) })

    @PostMapping(
        value = "/fake/outer/boolean",
        produces = { "*/*" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Boolean> fakeOuterBooleanSerialize(@Parameter(description = "Input boolean as post body"  )  @Valid @RequestBody(required = false) Boolean body) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /fake/outer/composite
     * Test serialization of object with outer number type
     *
     * @param outerComposite Input composite as post body (optional)
     * @return Output composite (status code 200)
     */
    @Operation(summary = "", operationId = "fakeOuterCompositeSerialize", tags={ "fake", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "200", description = "Output composite" , content = { @Content( schema = @Schema(implementation = OuterComposite.class)) }) })

    @PostMapping(
        value = "/fake/outer/composite",
        produces = { "*/*" },
        consumes = { "application/json" }
    )
    default ResponseEntity<OuterComposite> fakeOuterCompositeSerialize(@Parameter(description = "Input composite as post body"  )  @Valid @RequestBody(required = false) OuterComposite outerComposite) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("*/*"))) {
                    String exampleString = "{ \"my_string\" : \"my_string\", \"my_number\" : 0.8008281904610115, \"my_boolean\" : true }";
                    ApiUtil.setExampleResponse(request, "*/*", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /fake/outer/number
     * Test serialization of outer number types
     *
     * @param body Input number as post body (optional)
     * @return Output number (status code 200)
     */
    @Operation(summary = "", operationId = "fakeOuterNumberSerialize", tags={ "fake", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "200", description = "Output number" , content = { @Content( schema = @Schema(implementation = BigDecimal.class)) }) })

    @PostMapping(
        value = "/fake/outer/number",
        produces = { "*/*" },
        consumes = { "application/json" }
    )
    default ResponseEntity<BigDecimal> fakeOuterNumberSerialize(@Parameter(description = "Input number as post body"  )  @Valid @RequestBody(required = false) BigDecimal body) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /fake/outer/string
     * Test serialization of outer string types
     *
     * @param body Input string as post body (optional)
     * @return Output string (status code 200)
     */
    @Operation(summary = "", operationId = "fakeOuterStringSerialize", tags={ "fake", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "200", description = "Output string" , content = { @Content( schema = @Schema(implementation = String.class)) }) })

    @PostMapping(
        value = "/fake/outer/string",
        produces = { "*/*" },
        consumes = { "application/json" }
    )
    default ResponseEntity<String> fakeOuterStringSerialize(@Parameter(description = "Input string as post body"  )  @Valid @RequestBody(required = false) String body) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /fake/body-with-file-schema
     * For this test, the body for this request much reference a schema named &#x60;File&#x60;.
     *
     * @param fileSchemaTestClass  (required)
     * @return Success (status code 200)
     */
    @Operation(summary = "", operationId = "testBodyWithFileSchema", tags={ "fake", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "200", description = "Success" ) })

    @PutMapping(
        value = "/fake/body-with-file-schema",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> testBodyWithFileSchema(@Parameter(description = "" ,required=true )  @Valid @RequestBody FileSchemaTestClass fileSchemaTestClass) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /fake/body-with-query-params
     *
     * @param query  (required)
     * @param user  (required)
     * @return Success (status code 200)
     */
    @Operation(summary = "", operationId = "testBodyWithQueryParams", tags={ "fake", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "200", description = "Success" ) })

    @PutMapping(
        value = "/fake/body-with-query-params",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> testBodyWithQueryParams(@NotNull @Parameter(description = "", required = true) @Valid @RequestParam(value = "query", required = true) String query,@Parameter(description = "" ,required=true )  @Valid @RequestBody User user) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PATCH /fake : To test \&quot;client\&quot; model
     * To test \&quot;client\&quot; model
     *
     * @param client client model (required)
     * @return successful operation (status code 200)
     */
    @Operation(summary = "To test \"client\" model", operationId = "testClientModel", tags={ "fake", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "200", description = "successful operation" , content = { @Content( schema = @Schema(implementation = Client.class)) }) })

    @PatchMapping(
        value = "/fake",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Client> testClientModel(@Parameter(description = "client model" ,required=true )  @Valid @RequestBody Client client) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"client\" : \"client\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /fake : Fake endpoint for testing various parameters 假端點 偽のエンドポイント 가짜 엔드 포인트 
     * Fake endpoint for testing various parameters 假端點 偽のエンドポイント 가짜 엔드 포인트 
     *
     * @param number None (required)
     * @param _double None (required)
     * @param patternWithoutDelimiter None (required)
     * @param _byte None (required)
     * @param integer None (optional)
     * @param int32 None (optional)
     * @param int64 None (optional)
     * @param _float None (optional)
     * @param string None (optional)
     * @param binary None (optional)
     * @param date None (optional)
     * @param dateTime None (optional)
     * @param password None (optional)
     * @param paramCallback None (optional)
     * @return Invalid username supplied (status code 400)
     *         or User not found (status code 404)
     */
    @Operation(summary = "Fake endpoint for testing various parameters 假端點 偽のエンドポイント 가짜 엔드 포인트 ", operationId = "testEndpointParameters", security = {
        @SecurityRequirement(name = "http_basic_test"
        /*(TODO non OAuth auth), @Authorization(value = "http_basic_test") */
        ) }, tags={ "fake", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "400", description = "Invalid username supplied" ),
       @ApiResponse(responseCode = "404", description = "User not found" ) })

    @PostMapping(
        value = "/fake",
        consumes = { "application/x-www-form-urlencoded" }
    )
    default ResponseEntity<Void> testEndpointParameters(@Parameter(description = "None", required=true) @Valid @RequestPart(value = "number", required = true)  BigDecimal number,@Parameter(description = "None", required=true) @Valid @RequestPart(value = "double", required = true)  Double _double,@Parameter(description = "None", required=true) @Valid @RequestPart(value = "pattern_without_delimiter", required = true)  String patternWithoutDelimiter,@Parameter(description = "None", required=true) @Valid @RequestPart(value = "byte", required = true)  byte[] _byte,@Parameter(description = "None") @Valid @RequestPart(value = "integer", required = false)  Integer integer,@Parameter(description = "None") @Valid @RequestPart(value = "int32", required = false)  Integer int32,@Parameter(description = "None") @Valid @RequestPart(value = "int64", required = false)  Long int64,@Parameter(description = "None") @Valid @RequestPart(value = "float", required = false)  Float _float,@Parameter(description = "None") @Valid @RequestPart(value = "string", required = false)  String string,@Parameter(description = "None") @Valid @RequestPart(value = "binary", required = false) MultipartFile binary,@Parameter(description = "None") @Valid @RequestPart(value = "date", required = false)  LocalDate date,@Parameter(description = "None") @Valid @RequestPart(value = "dateTime", required = false)  OffsetDateTime dateTime,@Parameter(description = "None") @Valid @RequestPart(value = "password", required = false)  String password,@Parameter(description = "None") @Valid @RequestPart(value = "callback", required = false)  String paramCallback) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /fake : To test enum parameters
     * To test enum parameters
     *
     * @param enumHeaderStringArray Header parameter enum test (string array) (optional, default to new ArrayList&lt;&gt;())
     * @param enumHeaderString Header parameter enum test (string) (optional, default to -efg)
     * @param enumQueryStringArray Query parameter enum test (string array) (optional, default to new ArrayList&lt;&gt;())
     * @param enumQueryString Query parameter enum test (string) (optional, default to -efg)
     * @param enumQueryInteger Query parameter enum test (double) (optional)
     * @param enumQueryDouble Query parameter enum test (double) (optional)
     * @param enumFormStringArray Form parameter enum test (string array) (optional, default to $)
     * @param enumFormString Form parameter enum test (string) (optional, default to -efg)
     * @return Invalid request (status code 400)
     *         or Not found (status code 404)
     */
    @Operation(summary = "To test enum parameters", operationId = "testEnumParameters", tags={ "fake", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "400", description = "Invalid request" ),
       @ApiResponse(responseCode = "404", description = "Not found" ) })

    @GetMapping(
        value = "/fake",
        consumes = { "application/x-www-form-urlencoded" }
    )
    default ResponseEntity<Void> testEnumParameters(@Parameter(description = "Header parameter enum test (string array)" ) @RequestHeader(value="enum_header_string_array" , defaultValue="new ArrayList<>()", required=false) Optional<List<String>> enumHeaderStringArray,@Parameter(description = "Header parameter enum test (string)" ) @RequestHeader(value="enum_header_string" , defaultValue="-efg", required=false) Optional<String> enumHeaderString,@Parameter(description = "Query parameter enum test (string array)") @Valid @RequestParam(value = "enum_query_string_array", required = false) Optional<List<String>> enumQueryStringArray,@Parameter(description = "Query parameter enum test (string)", defaultValue = "-efg") @Valid @RequestParam(value = "enum_query_string", required = false, defaultValue="-efg") Optional<String> enumQueryString,@Parameter(description = "Query parameter enum test (double)") @Valid @RequestParam(value = "enum_query_integer", required = false) Optional<Integer> enumQueryInteger,@Parameter(description = "Query parameter enum test (double)") @Valid @RequestParam(value = "enum_query_double", required = false) Optional<Double> enumQueryDouble,@Parameter(description = "Form parameter enum test (string array)") @Valid @RequestPart(value = "enum_form_string_array", required = false)  List<String> enumFormStringArray,@Parameter(description = "Form parameter enum test (string)", defaultValue="-efg") @Valid @RequestPart(value = "enum_form_string", required = false)  String enumFormString) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /fake : Fake endpoint to test group parameters (optional)
     * Fake endpoint to test group parameters (optional)
     *
     * @param requiredStringGroup Required String in group parameters (required)
     * @param requiredBooleanGroup Required Boolean in group parameters (required)
     * @param requiredInt64Group Required Integer in group parameters (required)
     * @param stringGroup String in group parameters (optional)
     * @param booleanGroup Boolean in group parameters (optional)
     * @param int64Group Integer in group parameters (optional)
     * @return Someting wrong (status code 400)
     */
    @Operation(summary = "Fake endpoint to test group parameters (optional)", operationId = "testGroupParameters", security = {
        @SecurityRequirement(name = "bearer_test"
        /*(TODO non OAuth auth), @Authorization(value = "bearer_test") */
        ) }, tags={ "fake", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "400", description = "Someting wrong" ) })

    @DeleteMapping(
        value = "/fake"
    )
    default ResponseEntity<Void> testGroupParameters(@NotNull @Parameter(description = "Required String in group parameters", required = true) @Valid @RequestParam(value = "required_string_group", required = true) Integer requiredStringGroup,@Parameter(description = "Required Boolean in group parameters" ,required=true) @RequestHeader(value="required_boolean_group" , required=true) Boolean requiredBooleanGroup,@NotNull @Parameter(description = "Required Integer in group parameters", required = true) @Valid @RequestParam(value = "required_int64_group", required = true) Long requiredInt64Group,@Parameter(description = "String in group parameters") @Valid @RequestParam(value = "string_group", required = false) Optional<Integer> stringGroup,@Parameter(description = "Boolean in group parameters" ) @RequestHeader(value="boolean_group" , required=false) Optional<Boolean> booleanGroup,@Parameter(description = "Integer in group parameters") @Valid @RequestParam(value = "int64_group", required = false) Optional<Long> int64Group) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /fake/inline-additionalProperties : test inline additionalProperties
     *
     * @param requestBody request body (required)
     * @return successful operation (status code 200)
     */
    @Operation(summary = "test inline additionalProperties", operationId = "testInlineAdditionalProperties", tags={ "fake", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "200", description = "successful operation" ) })

    @PostMapping(
        value = "/fake/inline-additionalProperties",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> testInlineAdditionalProperties(@Parameter(description = "request body" ,required=true )  @Valid @RequestBody Map<String, String> requestBody) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /fake/jsonFormData : test json serialization of form data
     *
     * @param param field1 (required)
     * @param param2 field2 (required)
     * @return successful operation (status code 200)
     */
    @Operation(summary = "test json serialization of form data", operationId = "testJsonFormData", tags={ "fake", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "200", description = "successful operation" ) })

    @GetMapping(
        value = "/fake/jsonFormData",
        consumes = { "application/x-www-form-urlencoded" }
    )
    default ResponseEntity<Void> testJsonFormData(@Parameter(description = "field1", required=true) @Valid @RequestPart(value = "param", required = true)  String param,@Parameter(description = "field2", required=true) @Valid @RequestPart(value = "param2", required = true)  String param2) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /fake/test-query-paramters
     * To test the collection format in query parameters
     *
     * @param pipe  (required)
     * @param ioutil  (required)
     * @param http  (required)
     * @param url  (required)
     * @param context  (required)
     * @return Success (status code 200)
     */
    @Operation(summary = "", operationId = "testQueryParameterCollectionFormat", tags={ "fake", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "200", description = "Success" ) })

    @PutMapping(
        value = "/fake/test-query-paramters"
    )
    default ResponseEntity<Void> testQueryParameterCollectionFormat(@NotNull @Parameter(description = "", required = true) @Valid @RequestParam(value = "pipe", required = true) List<String> pipe,@NotNull @Parameter(description = "", required = true) @Valid @RequestParam(value = "ioutil", required = true) List<String> ioutil,@NotNull @Parameter(description = "", required = true) @Valid @RequestParam(value = "http", required = true) List<String> http,@NotNull @Parameter(description = "", required = true) @Valid @RequestParam(value = "url", required = true) List<String> url,@NotNull @Parameter(description = "", required = true) @Valid @RequestParam(value = "context", required = true) List<String> context) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /fake/{petId}/uploadImageWithRequiredFile : uploads an image (required)
     *
     * @param petId ID of pet to update (required)
     * @param requiredFile file to upload (required)
     * @param additionalMetadata Additional data to pass to server (optional)
     * @return successful operation (status code 200)
     */
    @Operation(summary = "uploads an image (required)", operationId = "uploadFileWithRequiredFile", security = {
        @SecurityRequirement(name = "petstore_auth", scopes = {
            "write:pets",
            "read:pets" }
        ) }, tags={ "pet", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "200", description = "successful operation" , content = { @Content( schema = @Schema(implementation = ModelApiResponse.class)) }) })

    @PostMapping(
        value = "/fake/{petId}/uploadImageWithRequiredFile",
        produces = { "application/json" },
        consumes = { "multipart/form-data" }
    )
    default ResponseEntity<ModelApiResponse> uploadFileWithRequiredFile(@Parameter(description = "ID of pet to update",required=true) @PathVariable("petId") Long petId,@Parameter(description = "file to upload") @Valid @RequestPart(value = "requiredFile", required = true) MultipartFile requiredFile,@Parameter(description = "Additional data to pass to server") @Valid @RequestPart(value = "additionalMetadata", required = false)  String additionalMetadata) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 0, \"type\" : \"type\", \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
