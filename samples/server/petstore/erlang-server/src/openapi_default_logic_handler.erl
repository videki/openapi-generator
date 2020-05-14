-module(openapi_default_logic_handler).

-behaviour(openapi_logic_handler).

-export([handle_request/3]).
-export([authorize_api_key/2]).
-export([authorize_api_key/2]).

-spec authorize_api_key(OperationID :: openapi_api:operation_id(), ApiKey :: binary()) -> {true, #{}}.

authorize_api_key(_, _) -> {true, #{}}.
-spec authorize_api_key(OperationID :: openapi_api:operation_id(), ApiKey :: binary()) -> {true, #{}}.

authorize_api_key(_, _) -> {true, #{}}.

-spec handle_request(
    OperationID :: openapi_api:operation_id(),
    Req :: cowboy_req:req(),
    Context :: #{}
) ->
    {Status :: cowboy:http_status(), Headers :: cowboy:http_headers(), Body :: jsx:json_term()}.

handle_request(OperationID, Req, Context) ->
    error_logger:error_msg(
        "Got not implemented request to process: ~p~n",
        [{OperationID, Req, Context}]
    ),
    {501, #{}, #{}}.
