import io.javalin.Javalin;
import io.javalin.openapi.plugin.OpenApiConfiguration;
import io.javalin.openapi.plugin.OpenApiPlugin;
import io.javalin.openapi.plugin.redoc.ReDocConfiguration;
import io.javalin.openapi.plugin.redoc.ReDocPlugin;
import io.javalin.openapi.plugin.swagger.SwaggerConfiguration;
import io.javalin.openapi.plugin.swagger.SwaggerPlugin;

public class Main {
    public static void main(String[] args) {
        Javalin.create(javalinConfig -> {
            OpenApiConfiguration openApiConfiguration = new OpenApiConfiguration();
            openApiConfiguration.getInfo().setTitle("My API");
            openApiConfiguration.getInfo().setVersion("1.0");
            openApiConfiguration.getInfo().setDescription("My API description");
            openApiConfiguration.getInfo().setTermsOfService("My API terms of service");
            javalinConfig.plugins.register(new OpenApiPlugin(openApiConfiguration));
            javalinConfig.plugins.register(new SwaggerPlugin(new SwaggerConfiguration()));
            javalinConfig.plugins.register(new ReDocPlugin(new ReDocConfiguration()));
        });
    }
}
