package org.example.jdbc3table.service.cart;

import org.example.jdbc3table.model.Cart;
import org.example.jdbc3table.model.DTO.CartDTO;
import org.example.jdbc3table.service.IGenericService;

import java.util.List;

public interface ICartService extends IGenericService<Cart> {
    List<CartDTO> showAllCart();
}
