package com.test.systemdesign.designpatterns.structural.decorator.pizzashop;

import lombok.Getter;

@Getter
abstract public class PizzaDecorator extends BasePizza {
    final private BasePizza basePizza;

    protected PizzaDecorator(final BasePizza basePizza) {
        super(basePizza.getSize(), basePizza.getDescription());
        this.basePizza = basePizza;
    }
}
