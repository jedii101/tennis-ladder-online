security {

	// see DefaultSecurityConfig.groovy for all settable/overridable properties

	active = true

	loginUserDomainClass = "Player"
	userName="userName"
	password="password"
	authorityDomainClass = "Authority"
	requestMapClass = "Requestmap"
        useMail="true"

        loginForUrl="/login/auth"
        afterLogoutUrl="/login/auth"
        defaultTargetUrl="/level/list"

    //url role mapping
    useRequestMapDomainClass = true
//
    new Requestmap(url: '/login/**', configAttribute: 'IS_AUTHENTICATED_ANONYMOUSLY').save()

new Requestmap(url: '/level/list*', configAttribute: 'IS_AUTHENTICATED_FULLY').save()
new Requestmap(url: '/level/create', configAttribute: 'ROLE_ADMIN').save()
new Requestmap(url: '/level/show', configAttribute: 'ROLE_ADMIN').save()
new Requestmap(url: '/level/edit', configAttribute: 'ROLE_ADMIN').save()

new Requestmap(url: '/authority/**', configAttribute: 'ROLE_ADMIN').save()
new Requestmap(url: '/defaultReason/**', configAttribute: 'ROLE_ADMIN').save()
new Requestmap(url: '/levelPosition/**', configAttribute: 'ROLE_ADMIN').save()
new Requestmap(url: '/player/**', configAttribute: 'ROLE_ADMIN').save()

new Requestmap(url: '/requestmap/**', configAttribute: 'ROLE_ADMIN').save()
new Requestmap(url: '/secure/**', configAttribute: 'ROLE_ADMIN').save()
new Requestmap(url: '/team/**', configAttribute: 'ROLE_ADMIN').save()



}
