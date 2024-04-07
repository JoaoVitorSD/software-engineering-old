package com.depollo.engineering.dto;

import java.util.UUID;

public record ProjectRequest (

        UUID id,
        String name,
        Float value,
        String description
){}
