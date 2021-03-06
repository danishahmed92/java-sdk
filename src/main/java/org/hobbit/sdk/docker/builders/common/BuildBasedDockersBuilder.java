package org.hobbit.sdk.docker.builders.common;

import org.hobbit.sdk.docker.BuildBasedDockerizer;
import com.spotify.docker.client.messages.PortBinding;

import java.io.Reader;
import java.nio.file.Paths;

public class BuildBasedDockersBuilder extends AbstractDockersBuilder {

    //private String imageNamePrefix="";
    private String buildDirectory;
    private Reader dockerFileReader;
    private Boolean useCachedImage;

    public BuildBasedDockersBuilder(String dockerizerName){
        super(dockerizerName);
    }

    public BuildBasedDockersBuilder dockerFileReader(Reader value) {
        this.dockerFileReader = value;
        return this;
    }

    public BuildBasedDockersBuilder buildDirectory(String value) {
        this.buildDirectory = value;
        return this;
    }

//    public BuildBasedDockersBuilder imageNamePrefix(String value){
//        this.imageNamePrefix = value;
//        return this;
//    }

    public BuildBasedDockersBuilder useCachedImage() {
        this.useCachedImage = true;
        return this;
    }

    public BuildBasedDockersBuilder useCachedImage(Boolean value) {
        this.useCachedImage = value;
        return this;
    }

    public BuildBasedDockersBuilder addPortBindings(String containerPort, PortBinding... hostPorts) {
        super.addPortBindings(containerPort, hostPorts);
        return this;
    }

    public BuildBasedDockersBuilder addEnvironmentVariable(String key, String value) {
        super.addEnvironmentVariable(key, value);
        return this;
    }

    public BuildBasedDockersBuilder containerName(String containerName) {
        super.containerName(containerName);
        return this;
    }

    public BuildBasedDockersBuilder hostName(String value) {
        super.hostName(value);
        return this;
    }

    public BuildBasedDockersBuilder imageName(String value) {
        super.imageName(value);
        return this;
    }


    public BuildBasedDockersBuilder skipLogsReading() {
        super.skipLogsReading();
        return this;
    }

    public BuildBasedDockersBuilder skipLogsReading(Boolean value) {
        super.skipLogsReading(value);
        return this;
    }

    public BuildBasedDockersBuilder useCachedContainer(){
        super.useCachedContainer();
        return this;
    }

    public BuildBasedDockersBuilder useCachedContainer(Boolean value){
        super.useCachedContainer(value);
        return this;
    }

    public BuildBasedDockersBuilder addNetworks(String... nets){
        super.addNetworks(nets);
        return this;
    }

    public String getBuildDirectory(){ return buildDirectory; }
    public Reader getDockerFileReader(){ return dockerFileReader; }
    public Boolean getUseCachedImage(){ return useCachedImage;}

    @Override
    public BuildBasedDockerizer build() throws Exception {


        if(buildDirectory==null)
            throw new Exception("Build directory is not specified for "+this.getClass().getSimpleName());

        if(dockerFileReader==null)
            throw new Exception("DockerFile reader is not specified for "+this.getClass().getSimpleName());

        BuildBasedDockerizer ret = new BuildBasedDockerizer(this);
        return ret;
    }
}
