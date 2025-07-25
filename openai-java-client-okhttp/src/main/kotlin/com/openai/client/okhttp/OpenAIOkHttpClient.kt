// File generated from our OpenAPI spec by Stainless.

package com.openai.client.okhttp

import com.fasterxml.jackson.databind.json.JsonMapper
import com.openai.azure.AzureOpenAIServiceVersion
import com.openai.client.OpenAIClient
import com.openai.client.OpenAIClientImpl
import com.openai.core.ClientOptions
import com.openai.core.Timeout
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.credential.Credential
import java.net.Proxy
import java.time.Clock
import java.time.Duration
import java.util.Optional
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

class OpenAIOkHttpClient private constructor() {

    companion object {

        /** Returns a mutable builder for constructing an instance of [OpenAIOkHttpClient]. */
        @JvmStatic fun builder() = Builder()

        @JvmStatic fun fromEnv(): OpenAIClient = builder().fromEnv().build()
    }

    /** A builder for [OpenAIOkHttpClient]. */
    class Builder internal constructor() {

        private var clientOptions: ClientOptions.Builder = ClientOptions.builder()
        private var timeout: Timeout = Timeout.default()
        private var proxy: Proxy? = null
        private var disableSslVerification: Boolean = false

        fun baseUrl(baseUrl: String) = apply { clientOptions.baseUrl(baseUrl) }

        /**
         * Whether to throw an exception if any of the Jackson versions detected at runtime are
         * incompatible with the SDK's minimum supported Jackson version (2.13.4).
         *
         * Defaults to true. Use extreme caution when disabling this option. There is no guarantee
         * that the SDK will work correctly when using an incompatible Jackson version.
         */
        fun checkJacksonVersionCompatibility(checkJacksonVersionCompatibility: Boolean) = apply {
            clientOptions.checkJacksonVersionCompatibility(checkJacksonVersionCompatibility)
        }

        fun jsonMapper(jsonMapper: JsonMapper) = apply { clientOptions.jsonMapper(jsonMapper) }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            clientOptions.streamHandlerExecutor(streamHandlerExecutor)
        }

        fun clock(clock: Clock) = apply { clientOptions.clock(clock) }

        fun headers(headers: Headers) = apply { clientOptions.headers(headers) }

        fun headers(headers: Map<String, Iterable<String>>) = apply {
            clientOptions.headers(headers)
        }

        fun putHeader(name: String, value: String) = apply { clientOptions.putHeader(name, value) }

        fun putHeaders(name: String, values: Iterable<String>) = apply {
            clientOptions.putHeaders(name, values)
        }

        fun putAllHeaders(headers: Headers) = apply { clientOptions.putAllHeaders(headers) }

        fun putAllHeaders(headers: Map<String, Iterable<String>>) = apply {
            clientOptions.putAllHeaders(headers)
        }

        fun replaceHeaders(name: String, value: String) = apply {
            clientOptions.replaceHeaders(name, value)
        }

        fun replaceHeaders(name: String, values: Iterable<String>) = apply {
            clientOptions.replaceHeaders(name, values)
        }

        fun replaceAllHeaders(headers: Headers) = apply { clientOptions.replaceAllHeaders(headers) }

        fun replaceAllHeaders(headers: Map<String, Iterable<String>>) = apply {
            clientOptions.replaceAllHeaders(headers)
        }

        fun removeHeaders(name: String) = apply { clientOptions.removeHeaders(name) }

        fun removeAllHeaders(names: Set<String>) = apply { clientOptions.removeAllHeaders(names) }

        fun queryParams(queryParams: QueryParams) = apply { clientOptions.queryParams(queryParams) }

        fun queryParams(queryParams: Map<String, Iterable<String>>) = apply {
            clientOptions.queryParams(queryParams)
        }

        fun putQueryParam(key: String, value: String) = apply {
            clientOptions.putQueryParam(key, value)
        }

        fun putQueryParams(key: String, values: Iterable<String>) = apply {
            clientOptions.putQueryParams(key, values)
        }

        fun putAllQueryParams(queryParams: QueryParams) = apply {
            clientOptions.putAllQueryParams(queryParams)
        }

        fun putAllQueryParams(queryParams: Map<String, Iterable<String>>) = apply {
            clientOptions.putAllQueryParams(queryParams)
        }

        fun replaceQueryParams(key: String, value: String) = apply {
            clientOptions.replaceQueryParams(key, value)
        }

        fun replaceQueryParams(key: String, values: Iterable<String>) = apply {
            clientOptions.replaceQueryParams(key, values)
        }

        fun replaceAllQueryParams(queryParams: QueryParams) = apply {
            clientOptions.replaceAllQueryParams(queryParams)
        }

        fun replaceAllQueryParams(queryParams: Map<String, Iterable<String>>) = apply {
            clientOptions.replaceAllQueryParams(queryParams)
        }

        fun removeQueryParams(key: String) = apply { clientOptions.removeQueryParams(key) }

        fun removeAllQueryParams(keys: Set<String>) = apply {
            clientOptions.removeAllQueryParams(keys)
        }

        fun timeout(timeout: Timeout) = apply {
            clientOptions.timeout(timeout)
            this.timeout = timeout
        }

        /**
         * Sets the maximum time allowed for a complete HTTP call, not including retries.
         *
         * See [Timeout.request] for more details.
         *
         * For fine-grained control, pass a [Timeout] object.
         */
        fun timeout(timeout: Duration) = timeout(Timeout.builder().request(timeout).build())

        fun maxRetries(maxRetries: Int) = apply { clientOptions.maxRetries(maxRetries) }

        fun proxy(proxy: Proxy) = apply { this.proxy = proxy }

        fun responseValidation(responseValidation: Boolean) = apply {
            clientOptions.responseValidation(responseValidation)
        }

        fun apiKey(apiKey: String) = apply { clientOptions.apiKey(apiKey) }

        fun credential(credential: Credential) = apply { clientOptions.credential(credential) }

        fun azureServiceVersion(azureServiceVersion: AzureOpenAIServiceVersion) = apply {
            clientOptions.azureServiceVersion(azureServiceVersion)
        }

        fun organization(organization: String?) = apply { clientOptions.organization(organization) }

        /** Alias for calling [Builder.organization] with `organization.orElse(null)`. */
        fun organization(organization: Optional<String>) = organization(organization.getOrNull())

        fun project(project: String?) = apply { clientOptions.project(project) }

        /** Alias for calling [Builder.project] with `project.orElse(null)`. */
        fun project(project: Optional<String>) = project(project.getOrNull())

        fun webhookSecret(webhookSecret: String?) = apply {
            clientOptions.webhookSecret(webhookSecret)
        }

        /** Alias for calling [Builder.webhookSecret] with `webhookSecret.orElse(null)`. */
        fun webhookSecret(webhookSecret: Optional<String>) =
            webhookSecret(webhookSecret.getOrNull())

        fun disableSslVerification(disable: Boolean = true) = apply { 
            this.disableSslVerification = disable 
        }

        fun fromEnv() = apply { clientOptions.fromEnv() }

        /**
         * Returns an immutable instance of [OpenAIClient].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): OpenAIClient =
            OpenAIClientImpl(
                clientOptions
                    .httpClient(
                        OkHttpClient.builder()
                            .timeout(timeout)
                            .proxy(proxy)
                            .disableSslVerification(disableSslVerification)
                            .build()
                    )
                    .build()
            )
    }
}
