package net.sf.openrocket.file.rocksim.export;

import net.sf.openrocket.rocketcomponent.EngineBlock;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 */
@XmlRootElement(name = "Ring")
@XmlAccessorType(XmlAccessType.FIELD)
public class EngineBlockDTO extends CenteringRingDTO{
    
    public EngineBlockDTO(EngineBlock eb) {
        super(eb);
        setUsageCode(UsageCode.EngineBlock);
    }
}
