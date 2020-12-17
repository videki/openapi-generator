/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.0.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import java.util.Map;
import org.openapitools.model.Order;
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
@Tag(name = "store", description = "the store API")
public interface StoreApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /store/order/{order_id} : Delete purchase order by ID
     * For valid response try integer IDs with value &lt; 1000. Anything above 1000 or nonintegers will generate API errors
     *
     * @param orderId ID of the order that needs to be deleted (required)
     * @return Invalid ID supplied (status code 400)
     *         or Order not found (status code 404)
     */
    @Operation(summary = "Delete purchase order by ID", operationId = "deleteOrder", tags={ "store", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "400", description = "Invalid ID supplied" ),
       @ApiResponse(responseCode = "404", description = "Order not found" ) })

    @DeleteMapping(
        value = "/store/order/{order_id}"
    )
    default ResponseEntity<Void> deleteOrder(@Parameter(description = "ID of the order that needs to be deleted",required=true) @PathVariable("order_id") String orderId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /store/inventory : Returns pet inventories by status
     * Returns a map of status codes to quantities
     *
     * @return successful operation (status code 200)
     */
    @Operation(summary = "Returns pet inventories by status", operationId = "getInventory", security = {
        @SecurityRequirement(name = "api_key"
        /*(TODO non OAuth auth), @Authorization(value = "api_key") */
        ) }, tags={ "store", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "200", description = "successful operation" , content = { @Content( mediaType = "Map",  schema = @Schema(implementation = Map.class)) }) })

    @GetMapping(
        value = "/store/inventory",
        produces = { "application/json" }
    )
    default ResponseEntity<Map<String, Integer>> getInventory() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /store/order/{order_id} : Find purchase order by ID
     * For valid response try integer IDs with value &lt;&#x3D; 5 or &gt; 10. Other values will generated exceptions
     *
     * @param orderId ID of pet that needs to be fetched (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Order not found (status code 404)
     */
    @Operation(summary = "Find purchase order by ID", operationId = "getOrderById", tags={ "store", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "200", description = "successful operation" , content = { @Content( schema = @Schema(implementation = Order.class)) }),
       @ApiResponse(responseCode = "400", description = "Invalid ID supplied" ),
       @ApiResponse(responseCode = "404", description = "Order not found" ) })

    @GetMapping(
        value = "/store/order/{order_id}",
        produces = { "application/xml", "application/json" }
    )
    default ResponseEntity<Order> getOrderById(@Min(1L) @Max(5L) @Parameter(description = "ID of pet that needs to be fetched",required=true) @PathVariable("order_id") Long orderId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"petId\" : 6, \"quantity\" : 1, \"id\" : 0, \"shipDate\" : \"2000-01-23T04:56:07.000+00:00\", \"complete\" : false, \"status\" : \"placed\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<Order> <id>123456789</id> <petId>123456789</petId> <quantity>123</quantity> <shipDate>2000-01-23T04:56:07.000Z</shipDate> <status>aeiou</status> <complete>true</complete> </Order>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /store/order : Place an order for a pet
     *
     * @param body order placed for purchasing the pet (required)
     * @return successful operation (status code 200)
     *         or Invalid Order (status code 400)
     */
    @Operation(summary = "Place an order for a pet", operationId = "placeOrder", tags={ "store", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "200", description = "successful operation" , content = { @Content( schema = @Schema(implementation = Order.class)) }),
       @ApiResponse(responseCode = "400", description = "Invalid Order" ) })

    @PostMapping(
        value = "/store/order",
        produces = { "application/xml", "application/json" }
    )
    default ResponseEntity<Order> placeOrder(@Parameter(description = "order placed for purchasing the pet" ,required=true )  @Valid @RequestBody Order body) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"petId\" : 6, \"quantity\" : 1, \"id\" : 0, \"shipDate\" : \"2000-01-23T04:56:07.000+00:00\", \"complete\" : false, \"status\" : \"placed\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<Order> <id>123456789</id> <petId>123456789</petId> <quantity>123</quantity> <shipDate>2000-01-23T04:56:07.000Z</shipDate> <status>aeiou</status> <complete>true</complete> </Order>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
