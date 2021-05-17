package com.hui.service.examine;

import com.hui.entity.examine.Cadre;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author 15837
 */
public interface CadreService {
    List<Cadre> selectSelective(Cadre cadre);
}
