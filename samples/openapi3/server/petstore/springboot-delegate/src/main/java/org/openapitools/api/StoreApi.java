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
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "store", description = "the store API")
public interface StoreApi {

    default StoreApiDelegate getDelegate() {
        return new StoreApiDelegate() {};
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
        return getDelegate().deleteOrder(orderId);
    }


    /**
     * GET /store/inventory : Returns pet inventories by status
     * Returns a map of status codes to quantities
     *
     * @return successful operation (status code 200)
     */
    @Operation(summary = "Returns pet inventories by status", operationId = "getInventory", security = {
        @SecurityRequirement(name = "api_key"
        @Authorization(value = "api_key")
         }, tags={ "store", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "200", description = "successful operation" , content = { @Content( mediaType = "Map",  schema = @Schema(implementation = Map.class)) }) })

    @GetMapping(
        value = "/store/inventory",
        produces = { "application/json" }
    )
    default ResponseEntity<Map<String, Integer>> getInventory() {
        return getDelegate().getInventory();
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
        return getDelegate().getOrderById(orderId);
    }


    /**
     * POST /store/order : Place an order for a pet
     *
     * @param order order placed for purchasing the pet (required)
     * @return successful operation (status code 200)
     *         or Invalid Order (status code 400)
     */
    @Operation(summary = "Place an order for a pet", operationId = "placeOrder", tags={ "store", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "200", description = "successful operation" , content = { @Content( schema = @Schema(implementation = Order.class)) }),
       @ApiResponse(responseCode = "400", description = "Invalid Order" ) })

    @PostMapping(
        value = "/store/order",
        produces = { "application/xml", "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Order> placeOrder(@Parameter(description = "order placed for purchasing the pet" ,required=true )  @Valid @RequestBody Order order) {
        return getDelegate().placeOrder(order);
    }

}
