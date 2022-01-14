package com.assignment.Springboot.audit;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;




    public class AuditImpl implements AuditorAware {

        public Optional getCurrentAuditor() {
            String name="System";
            return Optional.ofNullable(name);
        }
    }

