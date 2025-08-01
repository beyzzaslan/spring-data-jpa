package com.beyzaslan.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Server {
    //app.propertiesteki serverleri java koduna donusturuyorum
    private String ip;
    private String location;
}
