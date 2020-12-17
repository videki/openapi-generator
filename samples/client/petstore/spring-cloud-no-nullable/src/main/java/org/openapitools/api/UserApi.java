/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.0.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import java.util.List;
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
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "User", description = "the User API")
public interface UserApi {

    /**
     * POST /user : Create user
     * This can only be done by the logged in user.
     *
     * @param body Created user object (required)
     * @return successful operation (status code 200)
     */
    @Operation(summary = "Create user", operationId = "createUser", tags={ "user", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "200", description = "successful operation" ) })

    @PostMapping(
        value = "/user"
    )
    com.netflix.hystrix.HystrixCommand<ResponseEntity<Void>> createUser(@Parameter(description = "Created user object" ,required=true )  @Valid @RequestBody User body);


    /**
     * POST /user/createWithArray : Creates list of users with given input array
     *
     * @param body List of user object (required)
     * @return successful operation (status code 200)
     */
    @Operation(summary = "Creates list of users with given input array", operationId = "createUsersWithArrayInput", tags={ "user", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "200", description = "successful operation" ) })

    @PostMapping(
        value = "/user/createWithArray"
    )
    com.netflix.hystrix.HystrixCommand<ResponseEntity<Void>> createUsersWithArrayInput(@Parameter(description = "List of user object" ,required=true )  @Valid @RequestBody List<User> body);


    /**
     * POST /user/createWithList : Creates list of users with given input array
     *
     * @param body List of user object (required)
     * @return successful operation (status code 200)
     */
    @Operation(summary = "Creates list of users with given input array", operationId = "createUsersWithListInput", tags={ "user", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "200", description = "successful operation" ) })

    @PostMapping(
        value = "/user/createWithList"
    )
    com.netflix.hystrix.HystrixCommand<ResponseEntity<Void>> createUsersWithListInput(@Parameter(description = "List of user object" ,required=true )  @Valid @RequestBody List<User> body);


    /**
     * DELETE /user/{username} : Delete user
     * This can only be done by the logged in user.
     *
     * @param username The name that needs to be deleted (required)
     * @return Invalid username supplied (status code 400)
     *         or User not found (status code 404)
     */
    @Operation(summary = "Delete user", operationId = "deleteUser", tags={ "user", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "400", description = "Invalid username supplied" ),
       @ApiResponse(responseCode = "404", description = "User not found" ) })

    @DeleteMapping(
        value = "/user/{username}"
    )
    com.netflix.hystrix.HystrixCommand<ResponseEntity<Void>> deleteUser(@Parameter(description = "The name that needs to be deleted",required=true) @PathVariable("username") String username);


    /**
     * GET /user/{username} : Get user by user name
     *
     * @param username The name that needs to be fetched. Use user1 for testing. (required)
     * @return successful operation (status code 200)
     *         or Invalid username supplied (status code 400)
     *         or User not found (status code 404)
     */
    @Operation(summary = "Get user by user name", operationId = "getUserByName", tags={ "user", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "200", description = "successful operation" , content = { @Content( schema = @Schema(implementation = User.class)) }),
       @ApiResponse(responseCode = "400", description = "Invalid username supplied" ),
       @ApiResponse(responseCode = "404", description = "User not found" ) })

    @GetMapping(
        value = "/user/{username}",
        produces = "application/json"
    )
    com.netflix.hystrix.HystrixCommand<ResponseEntity<User>> getUserByName(@Parameter(description = "The name that needs to be fetched. Use user1 for testing.",required=true) @PathVariable("username") String username);


    /**
     * GET /user/login : Logs user into the system
     *
     * @param username The user name for login (required)
     * @param password The password for login in clear text (required)
     * @return successful operation (status code 200)
     *         or Invalid username/password supplied (status code 400)
     */
    @Operation(summary = "Logs user into the system", operationId = "loginUser", tags={ "user", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "200", description = "successful operation" , content = { @Content( schema = @Schema(implementation = String.class)) }),
       @ApiResponse(responseCode = "400", description = "Invalid username/password supplied" ) })

    @GetMapping(
        value = "/user/login",
        produces = "application/json"
    )
    com.netflix.hystrix.HystrixCommand<ResponseEntity<String>> loginUser(@NotNull @Parameter(description = "The user name for login", required = true) @Valid @RequestParam(value = "username", required = true) String username,@NotNull @Parameter(description = "The password for login in clear text", required = true) @Valid @RequestParam(value = "password", required = true) String password);


    /**
     * GET /user/logout : Logs out current logged in user session
     *
     * @return successful operation (status code 200)
     */
    @Operation(summary = "Logs out current logged in user session", operationId = "logoutUser", tags={ "user", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "200", description = "successful operation" ) })

    @GetMapping(
        value = "/user/logout"
    )
    com.netflix.hystrix.HystrixCommand<ResponseEntity<Void>> logoutUser();


    /**
     * PUT /user/{username} : Updated user
     * This can only be done by the logged in user.
     *
     * @param username name that need to be deleted (required)
     * @param body Updated user object (required)
     * @return Invalid user supplied (status code 400)
     *         or User not found (status code 404)
     */
    @Operation(summary = "Updated user", operationId = "updateUser", tags={ "user", })
    @ApiResponses(value = { 
       @ApiResponse(responseCode = "400", description = "Invalid user supplied" ),
       @ApiResponse(responseCode = "404", description = "User not found" ) })

    @PutMapping(
        value = "/user/{username}"
    )
    com.netflix.hystrix.HystrixCommand<ResponseEntity<Void>> updateUser(@Parameter(description = "name that need to be deleted",required=true) @PathVariable("username") String username,@Parameter(description = "Updated user object" ,required=true )  @Valid @RequestBody User body);

}
