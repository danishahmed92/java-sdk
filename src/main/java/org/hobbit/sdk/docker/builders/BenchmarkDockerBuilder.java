package org.hobbit.sdk.docker.builders;

import org.hobbit.sdk.JenaKeyValue;
import org.hobbit.sdk.docker.AbstractDockerizer;
import org.hobbit.sdk.docker.builders.common.AbstractDockersBuilder;
import org.hobbit.sdk.docker.builders.common.BothTypesDockersBuilder;
import org.hobbit.sdk.docker.builders.common.DynamicDockerFileBuilder;
import org.hobbit.sdk.docker.builders.common.PullBasedDockersBuilder;

import static org.hobbit.core.Constants.*;
import static org.hobbit.sdk.CommonConstants.*;


/**
 * @author Pavel Smirnov
 */

public class BenchmarkDockerBuilder extends BothTypesDockersBuilder {
    private static final String name = "benchmark-controller";
    private String parameters = new JenaKeyValue().encodeToString();

    public BenchmarkDockerBuilder(AbstractDockersBuilder builder) {
        super(builder);
    }

    public BenchmarkDockerBuilder parameters(String parameters){
        this.parameters = parameters;
        return this;
    }

    public BenchmarkDockerBuilder parameters(JenaKeyValue parameters){
        this.parameters = parameters.encodeToString();
        return this;
    }


    @Override
    public void addEnvVars(AbstractDockersBuilder ret) {
        ret.addEnvironmentVariable(RABBIT_MQ_HOST_NAME_KEY, (String)System.getenv().get(RABBIT_MQ_HOST_NAME_KEY));
        ret.addEnvironmentVariable(HOBBIT_SESSION_ID_KEY, (String)System.getenv().get(HOBBIT_SESSION_ID_KEY));
        ret.addNetworks(HOBBIT_NETWORKS);

        ret.addEnvironmentVariable(HOBBIT_EXPERIMENT_URI_KEY, (String)System.getenv().get(HOBBIT_EXPERIMENT_URI_KEY));
        ret.addEnvironmentVariable(BENCHMARK_PARAMETERS_MODEL_KEY, parameters);
        ret.addEnvironmentVariable(CONTAINER_NAME_KEY, ret.getContainerName());
    }

    @Override
    public String getName() {
        return name;
    }


}
