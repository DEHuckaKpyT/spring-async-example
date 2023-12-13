package com.example.lesson8.listener;

import lombok.Builder;
import lombok.Value;

/**
 * Created on 27.11.2023.
 * <p>
 *
 * @author Denis Matytsin
 */
@Value(staticConstructor = "of")
public class ExampleEvent {

    String name;
}
